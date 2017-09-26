var express = require('express');
var router = express.Router();

/* GET test api */
router.get('/test', function(req, res, next) {
  res.json({"result":"すいようのどようのうしのひ"});
});

router.get('/test2/:size(\\d+)', function(req, res, next) {

  var list = [];
  for (i = 1; i <= req.params.size; i++) {
    var map = {};
    map['key' + i] = 'value' + i;
    list.push(map);
  }

  var results = {};
  results.results = list;
  res.json(results);
});

module.exports = router;
