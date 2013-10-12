define(["marionette", "handlebars", "text!notification/notificationTemplate.hbs"], function(Marionette, Handlebars, notificationTemplate){
	return Marionette.ItemView.extend({
		tagName: "li",
		template: Handlebars.compile(notificationTemplate),
		events: {
			"click .close": "onClose"
		},
		onClose: function(){
			this.model.destroy();
		}
	});
});