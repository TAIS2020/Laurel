const loginService = require('./services/login-service')
const jwt = require("jsonwebtoken")

const loginController = {
    login: async (req, res) => {
        const idToken = req.body.idToken.toString()
        const user = await loginService.getSignedInUser(idToken)

        console.log(user)
        if (user == null) {
            res.status(401).send("Unauthorized");
            return
        }

        jwt.sign({user}, 'secretKey', (err, token) => {
            res.json({token})
        })
    }
}

module.exports = loginController
