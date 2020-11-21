const platform = {
    environment: process.env.LAUREL_MIDDLE_END_ENVIRONMENT || "dev",
    roles: {
        ADMIN: "admin",
        CUSTOMER: "customer",
    },
    secretKey: process.env.LAUREL_MIDDLE_END_SECRET_KEY || "secretKey"
}

module.exports = platform
