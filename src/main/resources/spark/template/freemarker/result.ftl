<html>
<head>
<!-- Pull the engine from the Quintus CDN or load it locally -->
<!-- (use quintus-all.min.js for production) -->
<script src='http://cdn.html5quintus.com/v0.2.0/quintus-all.js'></script>
</head>
<body>
	<script>
		// # Quintus moving ball example
		//
		// [Run the example](../examples/ball/index.html)
		//
		// This is one of the simplest possible examples of using 
		// Quintus that doesn't use the scene/stage functionality, 
		// but rather just creates a single sprite and steps and 
		// draws that sprite
		//
		// The goal of the example is to demonstrate the modularity
		// of the engine and the ability to only include the components
		// you actually need.

		// Wait for the load event to start the game.
		window.addEventListener("load", function() {

			// Create an instance of the engine, including only
			// the `Sprites` module, and then call setup to create a
			// canvas element on the page. If you already have a 
			// canvas element in your page, you can pass the element
			// or it's id as the first parameter to set up as well.
			var Q = window.Q = Quintus().include("Sprites, 2D").setup({
				maximize : true
			});

			// The `MovingSprite` class is a descendant of the base `Sprite` class,
			// all it does is add in a step method to Sprite that runs the standard
			// 2D motion equations using properties vx, vy for the velocity and ax, ay 
			// to calculate the new x and y positions.
			Q.MovingSprite.extend("Ball", {
				// Sprites by default expect either a `sheet` or an `asset` property
				// to draw themselves, but by overriding the draw method you can draw a 
				// shape directly on the canvas instead.
				draw : function(ctx) {
					ctx.fillStyle = this.p.color;
					ctx.beginPath();
					ctx.arc(-this.p.cx, -this.p.cy, this.p.w / 2, 0,
							Math.PI * 2);
					ctx.fill();
				}
			});

			Q.Ball.extend("Player1", {
				init : function(p) {
					this._super(p, {
						color : "red",
						w : 50,
						h : 50,
						x : 100,
						y : 300,
						vx : 40,
						vy : 0
					});

					/* this.add('2d');

					this.on("hit.sprite", function(collision) {
						alert("hit");
					}); */
				}
			});

			Q.Ball.extend("Player2", {
				init : function(p) {
					this._super(p, {
						color : "green",
						w : 50,
						h : 50,
						x : 400,
						y : 300,
						vx : 0,
						vy : 0
					});

					/* this.add('2d, platformerControls'); */ 
				}
			});

			// Create a new instance of the `Ball` Sprite,
			// passing in the size, position, velocity, and 
			// acceleration
			var ball = window.ball = new Q.Ball({
				color : "black",
				w : 20,
				h : 20,
				x : 150,
				y : 285,
				vx : 0,
				vy : 0,
				ax : 0,
				ay : 0
			});
			
			var player1 = window.player1 = new Q.Player1({vx:40});
			var player2 = window.player2 = new Q.Player2();

			/* Q.scene("level1", function(stage) {
				// Add in a tile layer, and make it the collision layer
				stage.collisionLayer(new Q.TileLayer());

				// Create the player and add him to the stage
				var player1 = stage.insert(new Q.Player1());
				var player2 = stage.insert(new Q.Player2());
			});

			Q.stageScene("level1"); */

			// You can start the game loop directly by
			// calling `gameLoop` with a callback and Quintus
			// will set up a requestAnimationFrame powered game loop
			// for you. Most examples don't call `gameLoop` directly as
			// calling `stageScene` will start a game loop that takes care
			// of clearing the canvas and updating and drawing all the stages
			// for you.
			 Q.gameLoop(function(dt) {
			    // Clear the canvas 
			    Q.clear();
			    //Q.debug = true;

			    // Move the ball `dt` forward in time
			    ball.update(dt);
			    player1.update(dt);
			    player2.update(dt);

			    // Render the ball onto the canvas context.
			    //console.log(player1.p.x)
			    if (player1.p.x >= ball.p.x - ball.p.w) { 
			  	  player1.p.vx = 0;
			  	  ball.p.vx = 40;
			 	  }
			    
			    if (ball.p.x >= player2.p.x - player2.p.w) { 
			  	  ball.p.vx = 0;
			 	  }
			    
			    ball.render(Q.ctx);
			    player1.render(Q.ctx);
			    player2.render(Q.ctx);
			}); 

			// ## Possible Experimentations:
			// 
			// 1. Try adding multiple balls of different positions and sizes
			//    and looping over them manually in game loop
			// 2. Change the clear color of the canvas
			// 3. Add in the `Scenes` module and create and stage a scene.
		});
	</script>
</body>
</html>