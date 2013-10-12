define(["backbone", "notification/notification"], function(Backbone, Notification){
	return Backbone.Collection.extend({
		model: Notification
	});
});