# -*- coding: utf-8 -*-
from flask import Flask, json, make_response 
import numpy as np

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

@app.route('/test2ByEmptyMap/<int:size>')
def test2ByEmptyMap(size):
    lst = [{}] * size
    for i in range(0, size):
        jsn = {"key" + str(i +1):"value" + str(i + 1)}
        lst[i] = jsn
    mp = {"results":lst}

    response = make_response(json.dumps(mp, ensure_ascii=False))
    response.headers['Content-Type'] = 'application/json; charset=utf-8'
    return response

@app.route('/test2ByNone/<int:size>')
def test2ByNone(size):
    lst = [None] * size
    for i in range(0, size):
        jsn = {"key" + str(i +1):"value" + str(i + 1)}
        lst[i] = jsn
    mp = {"results":lst}

    response = make_response(json.dumps(mp, ensure_ascii=False))
    response.headers['Content-Type'] = 'application/json; charset=utf-8'
    return response

@app.route('/test2ByComp/<int:size>')
def test2ByComp(size):
    lst = [{"key" + str(i):"value" + str(i)} for i in xrange(1, size + 1)]
    mp = {"results":lst}

    response = make_response(json.dumps(mp, ensure_ascii=False))
    response.headers['Content-Type'] = 'application/json; charset=utf-8'
    return response 

@app.route('/test2ByMap/<int:size>')
def test2ByMap(size):
    lst = map(createMap, xrange(size))
    mp = {"results":lst}

    response = make_response(json.dumps(mp, ensure_ascii=False))
    response.headers['Content-Type'] = 'application/json; charset=utf-8'
    return response 

def createMap(index):
    return {"key" + str(index + 1):"value" + str(index + 1)}

@app.route('/test2ByNumpy/<int:size>')
def test2ByNumpy(size):
    lst = list(np.array([{"key" + str(i):"value" + str(i)} for i in xrange(1, size + 1)]))
    mp = {"results":lst}

    response = make_response(json.dumps(mp, ensure_ascii=False))
    response.headers['Content-Type'] = 'application/json; charset=utf-8'
    return response 

if __name__ == '__main__':
    app.run('0.0.0.0', port=65000)

