const express = require('express');
const router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.json({ title: 'this is the api v1', environment: req.environment });
});

module.exports = router;