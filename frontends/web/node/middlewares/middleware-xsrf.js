const setXSRF = (req, res, next) => {
    res.cookie("XSRF-TOKEN", req.csrfToken());
    next();
}

module.exports = setXSRF
