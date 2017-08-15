package main

import (
	"fmt"
	"net/http"
	"encoding/json"
	"strconv"
)

func main() {
	http.HandleFunc("/", index)
	http.HandleFunc("/testString", testString)
	http.HandleFunc("/testMap", testMap)
	http.HandleFunc("/test2", test2)
	http.ListenAndServe(":7001", nil)
}

func index(w http.ResponseWriter, r *http.Request) {
	fmt.Fprint(w, "go api")
}

func testString(w http.ResponseWriter, r *http.Request) {
	result := `{"result":"すいようのどようのうしのひ"}`
	w.Header().Set("Content-Type", "application/json; charset=utf-8")
	fmt.Fprint(w, result)
}

func testMap(w http.ResponseWriter, r *http.Request) {
	result := map[string]string{"result":"すいようのどようのうしのひ"}
	w.Header().Set("Content-Type", "application/json; charset=utf-8")
	encoder := json.NewEncoder(w)
	encoder.Encode(result)
}

func test2(w http.ResponseWriter, r *http.Request) {

	var pSize string = r.FormValue("size")
	size, erorr := strconv.Atoi(pSize)
	if erorr != nil {
		size = 10
	}

	array := make([]map[string]string, size)
	for i := 0; i < size; i++ {
		key := "key" + strconv.Itoa(i + 1)
		value := "value" + strconv.Itoa(i + 1)
		array[i] = map[string]string{key:value}
	}

	results := map[string][]map[string]string{"results": array}
	w.Header().Set("Content-Type", "application/json; charset=utf-8")
	encoder := json.NewEncoder(w)
	encoder.Encode(results)
}
