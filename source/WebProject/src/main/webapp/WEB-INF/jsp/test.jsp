<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.itsci.fishshop.model.*,org.itsci.fishshop.dao.*,java.util.*"%>
<!DOCTYPE html>
<html>
  
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css/custom.css">
    
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Learn Bootstrap 5</title>
</head>

<style type="text/css">
header {
    background: url('../img/banner.jpg') no-repeat center center;
    background-size: cover;
    padding-top: 8rem;
    padding-bottom: 8rem;
    height: 500px;
}

.features-icons {
    padding-top: 5rem;
    padding-bottom: 5rem;
}

.features-icons-icon {
    font-size: 3rem;
    margin-bottom: 1rem;
    color: #0080ff;
}

.showcase-img {
    background-size: cover;
    min-height: 30rem;
}

.showcase-text {
    padding: 8rem;
}

.testimonials {
    padding-top: 7rem;
    padding-bottom: 7rem;
}

.testimonials .testimonials-item img {
    max-width: 12rem;
    box-shadow: 0 5px 5px #adb5bd;
}

.call-to-action {
    background: url("../img/banner.jpg") no-repeat center center;
    background-size: cover;
    padding-top: 7rem;
    padding-bottom: 7rem;
}

footer {
    padding-top: 4rem;
    padding-bottom: 4rem;
}

@media screen and (max-width: 360px) {
    .showcase-text {
        padding: 4rem;
    }

    .showcase-img {
        min-height: 15rem;
    }
}
</style>
<body>
<!-- Navbar  -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container">
        <a href="#" class="navbar-brand">MilerDev</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarToggler">
          <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a href="#" class="nav-link active" aria-current="page">Home</a>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link">About</a>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link">Services</a>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link">Contact</a>
            </li>
            <li class="nav-item">
              <button class="btn btn-outline-success" type="submit">Sign Up</button>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Header -->
    <header class="text-white text-center">
      <div class="container">
        <div class="row">
          <div class="col-xl-9 mx-auto">
            <h1 class="mb-5">Build the best landing page for your business or project with bootstrap 5!</h1>
          </div>

          <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
            <form action="">
              <div class="row d-flex">
                <div class="col-12 col-md-9 mb-2 mb-md-0">
                  <input type="email" class="form-control form-control-lg" placeholder="Enter your email...">
                </div>
                <div class="col-12 col-md-3">
                  <button type="submit" class="btn btn-block btn-lg btn-primary">Sign Up</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </header>

    <!-- Features icons -->
    <section class="features-icons bg-light text-center">
      <div class="container">
        <div class="row">
          <div class="col-lg-4">
            <div class="features-icons-item mx-auto mb-5 mb-lg-3">

              <div class="features-icons-icon">
                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-bounding-box-circles" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" d="M12.5 2h-9V1h9v1zm-10 1.5v9h-1v-9h1zm11 9v-9h1v9h-1zM3.5 14h9v1h-9v-1z"/>
                  <path fill-rule="evenodd" d="M14 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 1a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm0 11a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 1a2 2 0 1 0 0-4 2 2 0 0 0 0 4zM2 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 1a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm0 11a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 1a2 2 0 1 0 0-4 2 2 0 0 0 0 4z"/>
                </svg>
              </div>

              <h3>Fully Responsive</h3>

              <p class="lead mb-0">This theme will look great on any device, no matter the size!</p>
            </div>
          </div>

          <div class="col-lg-4">
            <div class="features-icons-item mx-auto mb-5 mb-lg-3">

              <div class="features-icons-icon">
                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-braces" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path d="M2.114 8.063V7.9c1.005-.102 1.497-.615 1.497-1.6V4.503c0-1.094.39-1.538 1.354-1.538h.273V2h-.376C3.25 2 2.49 2.759 2.49 4.352v1.524c0 1.094-.376 1.456-1.49 1.456v1.299c1.114 0 1.49.362 1.49 1.456v1.524c0 1.593.759 2.352 2.372 2.352h.376v-.964h-.273c-.964 0-1.354-.444-1.354-1.538V9.663c0-.984-.492-1.497-1.497-1.6zM13.886 7.9v.163c-1.005.103-1.497.616-1.497 1.6v1.798c0 1.094-.39 1.538-1.354 1.538h-.273v.964h.376c1.613 0 2.372-.759 2.372-2.352v-1.524c0-1.094.376-1.456 1.49-1.456V7.332c-1.114 0-1.49-.362-1.49-1.456V4.352C13.51 2.759 12.75 2 11.138 2h-.376v.964h.273c.964 0 1.354.444 1.354 1.538V6.3c0 .984.492 1.497 1.497 1.6z"/>
                </svg>
              </div>

              <h3>Bootstrap 5 Ready</h3>

              <p class="lead mb-0">Featuring the latest build of the new bootstrap 5 framework!</p>
            </div>
          </div>

          <div class="col-lg-4">
            <div class="features-icons-item mx-auto mb-5 mb-lg-3">

              <div class="features-icons-icon">
                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-check-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                  <path fill-rule="evenodd" d="M10.97 4.97a.75.75 0 0 1 1.071 1.05l-3.992 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.236.236 0 0 1 .02-.022z"/>
                </svg>
              </div>

              <h3>Easy to use</h3>

              <p class="lead mb-0">Ready to use with your own content, or customize the source files!</p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Image Showcase -->
    <section class="showcase"> 
      <div class="container-fluid p-0">
        <div class="row g-0">
          <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/showcase-1.jpg');"></div>
          <div class="col-lg-6 order-lg-1 my-auto showcase-text">
            <h2>Full Responsive Design</h2>
            <p class="lead mb-0">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quo est rerum, et magnam animi accusamus atque explicabo facilis! Minus, perferendis.</p>
          </div>
        </div>

        <div class="row g-0">
          <div class="col-lg-6 text-white showcase-img" style="background-image: url('img/showcase-2.jpg');"></div>
          <div class="col-lg-6 my-auto showcase-text">
            <h2>Updated for Bootstrap</h2>
            <p class="lead mb-0">Lorem ipsum dolor sit amet consectetur adipisicing elit. Itaque odit consequuntur provident exercitationem laboriosam facere, sed aliquid facilis minima. Nulla accusantium odit a est ipsam.</p>
          </div>
        </div>

        <div class="row g-0">
          <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/showcase-3.jpg');"></div>
          <div class="col-lg-6 order-lg-1 my-auto showcase-text">
            <h2>Easy to use &amp; Customize</h2>
            <p class="lead mb-0">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Sunt, ad tenetur itaque molestiae facilis libero at maxime optio saepe perferendis ipsum, laboriosam pariatur facere consectetur sit consequatur, cumque voluptate amet.</p>
          </div>
        </div>
      </div>
    </section>

    <!-- Testimonials -->
    <section class="testimonials text-center bg-light">
      <div class="container">
        <h2 class="mb-5">What people are saying...</h2>

        <div class="row">
          <div class="col-lg-4">
            <div class="testimonials-item mx-auto mb-5 mb-lg-0">
              <img src="img/testimonials-1.jpg" class="img-fluid rounded-circle mb-3" alt="">
              <h5>Margeret E.</h5>
              <p class="font-weight-light mb-0">"This is fantastic! Thanks so much guys!"</p>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="testimonials-item mx-auto mb-5 mb-lg-0">
              <img src="img/testimonials-2.jpg" class="img-fluid rounded-circle mb-3" alt="">
              <h5>Fred S.</h5>
              <p class="font-weight-light mb-0">"Bootstrap is amazing. I've been using it to create lots of super nice landing pages."</p>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="testimonials-item mx-auto mb-5 mb-lg-0">
              <img src="img/testimonials-3.jpg" class="img-fluid rounded-circle mb-3" alt="">
              <h5>Sarah W.</h5>
              <p class="font-weight-light mb-0">"Thanks so much for making these free resources available to us!"</p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Call to Action -->
    <section class="call-to-action text-white text-center">
      <div class="container">
        <div class="row">
          <div class="col-xl-9 mx-auto">
            <h2 class="mb-4">Ready to get started? Sign up now!</h2>
          </div>

          <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
            <form action="">
              <div class="row">
                <div class="col-12 col-md-9 mb-2 mb-md-0">
                  <input type="email" class="form-control form-control-lg" placeholder="Enter your email...">
                </div>
                <div class="col-12 col-md-3">
                  <button type="submit" class="btn btn-block btn-lg btn-primary">Sign up!</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>  

    <!-- Footer -->
    <footer class="bg-light">
      <div class="container">
        <div class="row">
          <div class="col-12 text-center">
            <p class="text-muted">&copy; MilerDev 2020. All Rights Reserved.</p>
          </div>
        </div>
      </div>
    </footer>
   
    
    <script src="js/bootstrap.min.js"></script>
</body>
</html>