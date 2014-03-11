;Quintus.PenaltyKicksScenes = function(Q) {

	Q.scene("players", function(stage) {
		//setting game state
		Q.state.set("goal", false);
		Q.state.set("readyToKick",true);
		//setting scene
		Q.clearStage();
		stage.insert(new Q.Background({type: Q.SPRITE_UI}));
		stage.insert(new Q.Goal());
		stage.insert(new Q.Kicker({vy:-40}));
		stage.insert(new Q.Ball({direction: Q.state.get("kickerMoves")[Q.state.get("nextMove")]}));
		stage.insert(new Q.Goalie({direction: Q.state.get("goalieMoves")[Q.state.get("nextMove")]}));
		Q.state.set("nextMove", Q.state.get("nextMove") + 1);
	});

	Q.scene('endGame',function(stage) {
	  var box = stage.insert(new Q.UI.Container({x: Q.width/2, y: Q.height/2, fill: "rgba(0,0,0,0.5)"}));
	  console.log("y ahora? Se ve?");
	  var button = box.insert(new Q.UI.Button({ x: 0, y: 0, fill: "#CCCCCC",label: "Play Again" }))         
	  var label = box.insert(new Q.UI.Text({x:10, y: -10 - button.p.h, label: stage.options.label }));
	  button.on("click",function() {
	    Q.clearStages();
	    Q.stageScene('players');
	  });
	  box.fit(20);
	});
};