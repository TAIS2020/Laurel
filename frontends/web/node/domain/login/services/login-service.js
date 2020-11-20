const admin = require("firebase-admin");

const loginService = async (idToken, expiresIn) => {
    try {
        return await admin.auth().createSessionCookie(idToken, { expiresIn })
    } catch(e) {
        console.log(e.message)
        return null
    }
}

module.exports = loginService
