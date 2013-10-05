define(["marionette", "routes/home/homeView", "routes/home/homeRouter"], function(Marionette, HomeView, HomeRouter){
	return Marionette.Controller.extend({
		initialize: function(options){
			this.contentRegion = options.contentRegion;
			this.homeRouter = new HomeRouter({
				controller: this
			});
		},
		showHomepage: function(){
			this.contentRegion.show(new HomeView());
		}
	});
});