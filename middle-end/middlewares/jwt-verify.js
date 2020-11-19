const verifyJWT = (req, res, next) => {
    console.log("Just chilling")
    next()
}

module.exports = verifyJWT
