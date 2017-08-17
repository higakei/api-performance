# -*- coding: utf-8 -*-
from flask import Flask, json, make_response 

app = Flask(__name__)

@app.route('/')
def index():
    return "python api"

@app.route('/test')
def test():
    data = {"result":"すいようのどようのうしのひ"}
    response = make_response(json.dumps(data, ensure_ascii=False))
    response.headers['Content-Type'] = 'application/json; charset=utf-8'
    return response

@app.route('/test2/<int:size>')
def test2(size):
    lst = []
    for i in range(1, size + 1):
        jsn = {"key" + str(i):"value" + str(i)}
        lst.append(jsn)
    mp = {"results":lst}

    response = make_response(json.dumps(mp, ensure_ascii=False))
    response.headers['Content-Type'] = 'application/json; charset=utf-8'
    return response 

@app.route('/test2Initialized/<int:size>')
def test2Initialized(size):
    lst = [{}] * size
    for i in range(0, size):
        jsn = {"key" + str(i +1):"value" + str(i + 1)}
        lst[i] = jsn
    mp = {"results":lst}

    response = make_response(json.dumps(mp, ensure_ascii=False))
    response.headers['Content-Type'] = 'application/json; charset=utf-8'
    return response

if __name__ == '__main__':
    app.run('0.0.0.0', port=65000)

