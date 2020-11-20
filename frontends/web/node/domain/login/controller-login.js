const loginService = require('./services/login-service')

const loginController = {
    login: async (req, res) => {
        const expiresIn = 60 * 60 * 24 * 5 * 1000;
        const idToken = req.body.idToken.toString()
        const sessionCookie = await loginService(idToken, expiresIn);

        if (sessionCookie ) {
            const options = { maxAge: expiresIn, httpOnly: true };
            res.cookie("session", sessionCookie, options);
            res.end(JSON.stringify({ status: "success" }));
        } else {
            res.status(401).send("UNAUTHORIZED REQUEST!");
        }
    },
    loginPage: (req, res) => {
        res.render("login.html");
    }
}

module.exports = loginController
