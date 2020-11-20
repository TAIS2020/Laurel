const admin = require("firebase-admin");

const service = {
    createSessionCookie: async (idToken, expiresIn) => {
        try {
            return await admin.auth()
                .createSessionCookie(idToken, { expiresIn })
        } catch(e) {
            console.log(e.message)
            return null
        }
    },
    verifyIdToken: async (idToken, checkRevoked = false) => {
        try {
            return await admin.auth().verifyIdToken(idToken, checkRevoked)
        } catch (e) {
            console.log(e.message)
            return null
        }
    },
    getUser: async (uid) => {
        try {
            return await admin.auth().getUser(uid)
        } catch (e) {
            console.log(e.message)
            return null
        }
    },
    getSignedInUser: async (idToken) => {
        try {
            const decoded = await admin.auth().verifyIdToken(idToken)
            return await admin.auth().getUser(decoded.uid)
        } catch (e) {
            console.log(e.message)
            return null
        }
    }
}

module.exports = service
