define(["marionette", "handlebars", "text!navigation/navLayout.html"], function(Marionette, Handlebars, navLayout){
	return Marionette.Layout.extend({
		tagName: "nav",
		className: "navbar navbar-default",
		attributes: {
			role: "navigation"
		},
		template: Handlebars.compile(navLayout),
		regions: {
			siteNavigation: "#siteNav",
			userNavigation: "#userNav"
		}
	});
});