define(["marionette", "handlebars", "text!routes/home/homeTemplate.hbs"], function(Marionette, Handlebars, homeTemplate){
	return Marionette.ItemView.extend({
		className: "col-md-12",
		template: Handlebars.compile(homeTemplate)
	});
});