const _ = require('lodash')

const isAuthorized = (options) => {

    const authorizedRoles = options.hasRoles

    return (req, res, next) => {
        if (req.locals && req.locals.decodedUser && req.locals.decodedUser.user && req.locals.decodedUser.user.customClaims) {
            const user = req.locals.decodedUser.user
            let isAuthorized = false

            _.forEach(authorizedRoles, (rol) => {
                isAuthorized = isAuthorized || (user.customClaims.hasOwnProperty(rol) && user.customClaims[rol])
            })

            if (isAuthorized) {
                next()
                return
            }
        }

        res.sendStatus(403)
    }
}

module.exports = isAuthorized
