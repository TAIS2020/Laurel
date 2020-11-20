const verifyJWT = (req, res, next) => {
    const authorizationHeader = req.headers['authorization'];

    if (typeof authorizationHeader !== 'undefined') {
        const bearerToken = authorizationHeader.split(" ")[1]
        req.token = bearerToken
        next()
    } else {
        res.sendStatus(403)
    }
}

module.exports = verifyJWT
