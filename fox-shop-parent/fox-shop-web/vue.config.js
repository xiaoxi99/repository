module.exports = {
    baseUrl: './',
    assetsDir: 'static',
    productionSourceMap: false,
    devServer: {
        proxy: {
            '/wow-api':{
                target:'http://localhost:9080',
                changeOrigin:false,
                pathRewrite:{
                    '^/wow-api':'/'
                }
            }
        }
    }
}