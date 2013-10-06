define(["marionette", "handlebars", "text!routes/idea/ideaSaveUpdateTemplate.hbs"], function(Marionette, Handlebars, ideaSaveUpdateTemplate){
	return Marionette.ItemView.extend({
		tagName: "form",
		attributes: {
			id: "ideaForm",
			role: "form"
		},
		template: Handlebars.compile(ideaSaveUpdateTemplate),
		ui: {
			title: "#title",
			description: "#description"
		},
		triggers: {
			"submit": "idea:save"
		},
		events: {
			"change #title": "titleChanged",
			"change #description": "descriptionChanged"
		},
		titleChanged: function(){
			this.model.set("title", this.ui.title.val());
		},
		descriptionChanged: function(){
			this.model.set("description", this.ui.description.val());
		}
	});
});