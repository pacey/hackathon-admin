define(["marionette", "handlebars", "text!routes/home/homeTemplate.hbs"], function(Marionette, Handlebars, homeTemplate){
	return Marionette.ItemView.extend({
		template: Handlebars.compile(homeTemplate)
	});
});