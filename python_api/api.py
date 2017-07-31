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

if __name__ == '__main__':
    app.run(debug=True)

