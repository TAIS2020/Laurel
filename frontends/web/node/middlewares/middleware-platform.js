const platform = require("../config/config")

const setEnvironment = (req, res, next) => {
    req.environment = platform.environment
    next()
}

module.exports = setEnvironment
