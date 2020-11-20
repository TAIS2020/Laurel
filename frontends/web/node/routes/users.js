const express = require('express');
const router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  let test = {
    hello: "world"
  }
  res.send(test);
});

module.exports = router;
