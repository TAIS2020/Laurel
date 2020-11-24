const jwt = require("jsonwebtoken")
const { secretKey } = require('../config/config')

const verifyJWT = (req, res, next) => {
    const authorizationHeader = req.headers['authorization'];

    if (typeof authorizationHeader !== 'undefined') {
        const bearerToken = authorizationHeader.split(" ")[1]
        req.token = bearerToken
        req.locals = {...res.locals, decodedUser: jwt.verify(req.token, secretKey)}
        next()
    } else {
        res.sendStatus(403)
    }
}

module.exports = verifyJWT
