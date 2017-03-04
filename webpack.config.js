/**
 * Created by Marlin on 2/24/2017.
 */

var path = require('path');
var webpack = require('webpack');

module.exports = {
    entry: {
        app: './app.js',
        app2: './app2.js',
        app3: './app3.js',
        app4: './app4.js',
    },

    output: {
        path: __dirname,
        filename: '[name].all.js'
    },

    module: {
        loaders: [
            {
                test: /.jsx?$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    presets: ['es2015', 'react']
                }
            }
        ]
    },
};