package main

import (
	"encoding/json"
	"fmt"
	"net/http"
	"strconv"
	"github.com/julienschmidt/httprouter"
)

func main() {
	router := httprouter.New()
	router.GET("/", index)
	router.GET("/testString", testString)
	router.GET("/testMap", testMap)
	router.GET("/test2", test2Index)
	router.GET("/test2/:size", test2)
	http.ListenAndServe(":57001", router)
}

func index(w http.ResponseWriter, r *http.Request, _ httprouter.Params) {
	fmt.Fprintln(w, "go api")
}

func testString(w http.ResponseWriter, r *http.Request, _ httprouter.Params) {
	result := `{"result":"すいようのどようのうしのひ"}`
	w.Header().Set("Content-Type", "application/json; charset=utf-8")
	fmt.Fprint(w, result)
}

func testMap(w http.ResponseWriter, r *http.Request, _ httprouter.Params) {
	result := map[string]string{"result": "すいようのどようのうしのひ"}
	w.Header().Set("Content-Type", "application/json; charset=utf-8")
	encoder := json.NewEncoder(w)
	encoder.Encode(result)
}

func test2Index(w http.ResponseWriter, r *http.Request, _ httprouter.Params) {

	array := CreateTest2Response(10)
	results := map[string][]map[string]string{"results": array}

	w.Header().Set("Content-Type", "application/json; charset=utf-8")
	encoder := json.NewEncoder(w)
	encoder.Encode(results)
}

func test2(w http.ResponseWriter, r *http.Request, ps httprouter.Params) {

	var pSize string = ps.ByName("size")
	size, erorr := strconv.Atoi(pSize)
	if erorr != nil {
		size = 10
	}

	array := CreateTest2Response(size)
	results := map[string][]map[string]string{"results": array}

	w.Header().Set("Content-Type", "application/json; charset=utf-8")
	encoder := json.NewEncoder(w)
	encoder.Encode(results)
}

func CreateTest2Response(size int) []map[string]string {

	array := make([]map[string]string, size)
	for i := 0; i < size; i++ {
		key := "key" + strconv.Itoa(i+1)
		value := "value" + strconv.Itoa(i+1)
		array[i] = map[string]string{key: value}
	}

	return array
}