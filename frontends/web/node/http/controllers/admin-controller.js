const adminService = require('../../services/admin-services')

const controller = {
    grant: async (req, res) => {
        const idToken = req.body.idToken.toString()
        const result = await adminService.grantAdmin(idToken)

        if (result === false) {
            res.status(404).send("Token id not found");
            return
        }

        res.json({ result })
    }
}

module.exports = controller
