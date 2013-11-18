requirejs.config({
    paths: {
        jquery: "libs/jquery-2.0.3",
        text: 'libs/text',
        underscore: "//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min",
        backbone: "//cdnjs.cloudflare.com/ajax/libs/backbone.js/1.0.0/backbone-min",
        marionette: "//cdnjs.cloudflare.com/ajax/libs/backbone.marionette/1.1.0-bundled/backbone.marionette.min",
        handlebars: "//cdnjs.cloudflare.com/ajax/libs/handlebars.js/1.0.0/handlebars.min",
        bootstrap: "//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.0/js/bootstrap.min",
        moment: "//cdnjs.cloudflare.com/ajax/libs/moment.js/2.2.1/moment.min"
    },
    shim: {
        jquery: {
            exports: "jQuery"
        },
        underscore: {
            exports: "_"
        },
        handlebars: {
            exports: "Handlebars"
        },
        bootstrap: {
            deps: ["jquery"],
            exports: "jQuery.fn.modal"
        },
        backbone: {
            exports: "Backbone",
            deps: ["underscore", "jquery"]
        },
        marionette: {
            exports: "Backbone.Marionette",
            deps: ["backbone"]
        }
    }
});

requirejs(["application", "bootstrap"], function(application) {
    application.start();
});