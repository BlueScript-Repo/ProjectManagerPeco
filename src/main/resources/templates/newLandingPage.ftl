<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="./css/landing.css" />
    <title>PECO Industries</title>
  </head>

  <body data-spy="scroll" data-target="#main-nav" id="home">

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top" id="main-nav">
        <div class="container">
            <img src="./images/img/PECOLogo1.jpg" alt="" class="navbar-brand">
        </div>
    </nav>

    <!--HOME SECTION-->
    <header id="home-section">
      <div class="dark-overlay">
        <div class="home-inner container">
          <div class="row">
            <div class="col-lg-6 offset-lg-1 d-none d-lg-block">
              <h1 class="display-4 pl-4 pt-4">
                Project & Inventory <span class="ml-5">Management</span>
              </h1>
              <div class="d-flex">
                <div class="p-4 align-self-start">
                  Efficient way of managing Project workflow and Inventory
                </div>
              </div>
            </div>
            <div class="col-lg-4 offset-lg-1">
              <div class="card text-center card-form">
                <div class="card-body">
                  <h3>Log In</h3>
                  <form id="updateInv" action="submit" method="POST">
                    <div class="form-group">
                    <label
                      for="inputUserName"
                      class="text-md-right control-label col-form-label font-weight-bold"
                      >User Name</label
                    >
                    <input
                      class="form-control"
                      type="userName"
                      name="userName"
                      id="inputUserName"
                      style="width: 100%;"
                      required
                    />
                </div>
                <div class="form-group">
                    <label
                      for="inputPassword"
                      class="text-md-right control-label col-form-label font-weight-bold"
                      >Password</label
                    >
                    <input
                      class="form-control"
                      type="Password"
                      name="password"
                      id="inputPassword"
                      style="width: 100%;"
                      required
                    />
                </div>
                 <div class="form-group">
                    <button
                      type="submit"
                      class="btn btn-default block"
                      style="background-color: #778899;"
                    >
                      Log In
                    </button>
                </div>
                <div class="separator clearfix"></div>
                <p><a class="text-white" href="reset">Forgot Password?</a></p>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </header>

    <footer id="main-footer" class="bg-dark">
      <div class="container">
        <div class="row">
          <div class="col text-center py-4">
            <h5>Powred BY : Social Angels Digital Co.</h5>
            <p>Copyright &copy; <span id="year"></span></p>
          </div>
        </div>
      </div>
    </footer>

    
    <script
      src="http://code.jquery.com/jquery-3.5.1.min.js"
      integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
      integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
      integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
      crossorigin="anonymous"
    ></script>

    <script>
      $("#year").text(new Date().getFullYear());

      //Scroll Spy
      $("body").scrollspy({ target: "main-nav" });

      //Smooth scrolling

      $("#main-nav a").on("click", function (event) {
        if (this.hash !== "") {
          event.preventDefault();

          const hash = this.hash;

          $("html, body").animate(
            {
              scrollTop: $(hash).offset().top,
            },
            800,
            function () {
              window.location.hash = hash;
            }
          );
        }
      });
    </script>
    <script>
        //Array of images which you want to show: Use path you want.
        var images=new Array('./images/img/architecture.jpg','./images/img/refinery.jpg','./images/img/pipes.jpg','./images/img/wheel.jpg','./images/img/valve.jpg');
        var nextimage=0;
        doSlideshow();
        
        function doSlideshow(){
            if(nextimage>=images.length){nextimage=0;}
            $('#home-section')
            .css('background','url("'+images[nextimage++]+'")')
            .fadeIn(1000,function(){
                setTimeout(doSlideshow,6000);
            });
        }
        </script>
  </body>
</html>
