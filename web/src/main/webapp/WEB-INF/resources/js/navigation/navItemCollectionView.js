define(["marionette", "navigation/navItemCollection", "navigation/navItemView"], function(Marionette, NavItemCollection, NavItemView){
	return Marionette.CollectionView.extend({
		tagName: "ul",
		className: function(){
			var className = "nav navbar-nav";
			if(this.options.right){
				className += " navbar-right"
			}
			return className;
		},
		collection: NavItemCollection,
		itemView: NavItemView
	});
});