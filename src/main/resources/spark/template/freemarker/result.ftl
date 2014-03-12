<html>
<head>
<script src='quintus/lib/v0.2.0/quintus-all.js'></script>
<script src='javascripts/penalty-kicks-sprites.js'></script>
<script src='javascripts/penalty-kicks-scenes.js'></script>
</head>
<body>
	<script>
	var winner = "${getWinner()}";
	//player  moves
	var MOVE_CENTER = 0;
	var MOVE_RIGHT = 1;
	var MOVE_LEFT = -1;
	
	window.addEventListener("load", function() {
	
		var Q = window.Q = Quintus().include("Sprites, 2D, Scenes, Anim, UI, Input, Touch")
									.include("PenaltyKicksSprites, PenaltyKicksScenes")
									.setup({maximize : true}).touch();
		
		//Q.debug = true;
		//Q.debugFill = true;

		var kickerMoves = [];
		var goalieMoves = [];
	
	<#assign moveCount = 1>
	<#list  getMatchLog().getMoves() as move>
		kickerMoves[${moveCount}]=MOVE_${move.getKickPosition()};
		goalieMoves[${moveCount}]=MOVE_${move.getDivePosition()};
		<#assign moveCount = moveCount + 1>	
	</#list>
	
		Q.state.set("kickerMoves", kickerMoves);
		Q.state.set("goalieMoves", goalieMoves);
		Q.state.set("nextMove", 1);
		
		Q.load("goalie.json, goalie.png, background.png", function() {
		    Q.compileSheets("goalie.png","goalie.json");
		    Q.animations("goalie", {
		      jump_right: { frames: [3,3,4,4,4,5,5,6], rate: 1/4, flip: false, loop: false},
		      jump_left: { frames: [3,2,2,2,1,1,0], rate: 1/4, flip: false, loop: false },
		      stand: { frames: [3], rate: 1/4, flip: false, loop: false },
		    });
		});
	
		Q.stageScene("players");
	});
	</script>
</body>
</html>