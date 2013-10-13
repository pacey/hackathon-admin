define(["marionette", "handlebars", "text!routes/idea/ideaCollectionEmptyTemplate.hbs"], function(Marionette, Handlebars, ideaCollectionEmptyTemplate){
	return Marionette.ItemView.extend({
		tagName: "li",
		template: Handlebars.compile(ideaCollectionEmptyTemplate)
	});
});