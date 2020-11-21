const admin = require("firebase-admin");

const service = {
    grantAdmin: async (idToken) => {
        try {
            const decoded = await admin.auth().verifyIdToken(idToken)
            const user = await admin.auth().getUser(decoded.uid)

            if (user.customClaims && user.customClaims.admin === true) {
                return true
            }

            await admin.auth().setCustomUserClaims(user.uid, {
                admin: true,
            })

            return true
        } catch (e) {
            console.log(e)
            return false
        }
    },
}

module.exports = service
