define(["marionette", "handlebars", "text!routes/idea/ideaTemplate.hbs"], function(Marionette, Handlebars, ideaTemplate){
	return Marionette.ItemView.extend({
		tagName: "li",
		template: Handlebars.compile(ideaTemplate),
		events:{
			"click .js-delete": "deleteMe"
		},
		deleteMe: function(event){
			event.preventDefault();
			this.model.destroy();
		}
	});
});