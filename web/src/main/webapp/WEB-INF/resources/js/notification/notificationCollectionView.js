define(["marionette", "notification/notificationView", "notification/notificationCollection"], function(Marionette, NotificationView, NotificationCollection){
	return Marionette.CollectionView.extend({
		tagName: "ul",
		className: "col-md-12 list-unstyled",
		itemView: NotificationView,
		initialize: function(){
			this.collection = new NotificationCollection();
		},
		addNotification: function(notification){
			this.collection.add(notification);
		}
	});
});