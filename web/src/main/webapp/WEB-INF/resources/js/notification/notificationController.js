define(["marionette", "notification/notificationCollectionView"], function(Marionette, NotificationCollectionView){
	return Marionette.Controller.extend({
		initialize: function(options){
			this.notificationRegion = options.notificationRegion;
			this.notificationCollectionView = new NotificationCollectionView();
			this.notificationRegion.show(this.notificationCollectionView);
		},
		addNotification: function(notification){
			this.notificationCollectionView.addNotification(notification);
		}
	});
});