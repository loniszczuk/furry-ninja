<html>
<head>
<!-- Pull the engine from the Quintus CDN or load it locally -->
<!-- (use quintus-all.min.js for production) -->
<script src='http://cdn.html5quintus.com/v0.2.0/quintus-all.js'></script>
</head>
<body>
	<script>
		window.addEventListener("load", function() {

			var Q = window.Q = Quintus().include("Sprites, 2D, Scenes, Anim").setup({
				maximize : true
			});
			
			Q.gravityX = 0;
			Q.gravityY = 0;
			//Q.debug = true;
			//Q.debugFill = true;

			Q.Sprite.extend("Goal", {
				init : function (p) {
					this._super(p, {
						color : "black",
						w : 300,
						h : 20,
						x : 280,
						y : 30,
					});
					this.add("2d");
					this.on("hit", this, "collision");
				},
				draw : function(ctx) {
					ctx.fillStyle = "black";
					ctx.beginPath();
					ctx.fillRect(this.p.cx, -this.p.cy, -10, this.p.h + 50);
					ctx.fillRect(-this.p.cx, -this.p.cy, 10, this.p.h + 50);
					ctx.fillRect(-this.p.cx, -this.p.cy, this.p.w, this.p.h);
				},
				collision : function() {
					console.log("Goal!!")					
				} 
			});

			Q.MovingSprite.extend("AbstractBall", {
				stop : function() {
					this.p.vy = 0;
					this.p.vx = 0;
				},
				draw : function(ctx) {
					ctx.fillStyle = this.p.color;
					ctx.beginPath();
					ctx.arc(-this.p.cx, -this.p.cy, this.p.w / 2, 0,
							Math.PI * 2);
					ctx.fill();
				}
			});

			Q.AbstractBall.extend("Ball", {
				init : function(p) {
					this._super(p, {
						color : "black",
						w : 20,
						h : 20,
						x : 285,
						y : 300
					});
					this.add("2d");
					console.log("Ball created");
					this.on("hit", this, "collision");
				},
				
				moveToGoal : function() {
					this.p.vy = -90;
					this.p.vx = -50 * this.p.direction;
				},
				collision: function(col) {
				  console.log("Ball collision!")
				  if(this.p.vx != 0 || this.p.vy != 0) {
				  	console.log("Ball moving, then stop")
					this.stop();
				  }else {
				  	console.log("moving ball!");
					this.moveToGoal();
				  }
				},
			});

			Q.AbstractBall.extend("Player1", {
				init : function(p) {
					this._super(p, {
						color : "red",
						w : 50,
						h : 50,
						x : 300,
						y : 380
					});
					this.add("2d")
					this.on("hit", this, "collision");
				},
				collision: function(col) {
					console.log("Player 1 collision!");
					this.stop();
				}
			});

			Q.Sprite.extend("Goalie", {
				init : function(p) {
					this._super(p, {
						sheet: "goalie",
						sprite: "goalie",
						x : 280,
						y : 100,
						vy : 0,
						w : 145,
						h : 103,
						jump : false,
						scale : 1,
						standingPoints: [[-30,-50],[30,-50],[30,50],[-30,50]],
						jumpingPoints: [[-72,-25],[72,-25],[72,25],[-72,25]],
					});
					this.p.points = this.p.standingPoints;
					this.add("2d, animation");
					this.play("stand");
					this.on("hit", this, "collision");
				},
					
				step : function(dt) {
				},

				move : function() {
					if (this.p.vx == 0 && !this.p.jump) {
						this.p.jump = true;
						this.p.points = this.p.jumpingPoints;
						this.moveRight(this)
					}
				},
				
				moveRight : function(p) {
					this.p.vx = 60;
				    this.play("jump_right");
				},

				moveLeft : function(p) {
					this.p.vx = -15;
				    this.play("jump_left");
				},				

				stop : function() {
					this.p.vx = 0;
					this.p.vy = 0;
				},
				   
   				collision: function(col) {
					this.stop();
				}
			});

			var goal;
			var ball;
			var player1;
			var player2;
			
			Q.scene("move1", function(stage) {
				goal = stage.insert(new Q.Goal());
				ball = stage.insert(new Q.Ball({direction:-1}));
				player1 = stage.insert(new Q.Player1({vy:-40}));
				player2 = stage.insert(new Q.Goalie());
				player2.move();
			});
		

			Q.gameLoop(function(dt) {
				Q.clear();

				goal.update(dt);
				ball.update(dt);
				player1.update(dt);
				player2.update(dt);
	

				ball.render(Q.ctx);
				player1.render(Q.ctx);
				player2.render(Q.ctx);
				goal.render(Q.ctx);
			});
			
			Q.load("goalie.json, goalie.png", function() {
			    Q.compileSheets("goalie.png","goalie.json");
			    Q.animations("goalie", {
			      jump_right: { frames: [3,4,5,6], rate: 1/4, flip: false, loop: false},
			      jump_left: { frames: [3,2,1,0], rate: 1/4, flip: false, loop: false },
			      stand: { frames: [3], rate: 1/5, flip: false, loop: false },
			    });
			});

			Q.stageScene("move1");
		});
	</script>
</body>
</html>