// custom.js
// This snippet is used to display the Contact Us modal after 1 minute of the user being on the page.
document.addEventListener('DOMContentLoaded', (event) => {
    setTimeout(function() {
        document.getElementById('contactModal').style.display = 'flex';
    }, 60000); // 60000 milliseconds = 1 minute

    document.getElementById('contactButton').addEventListener('click', function() {
        window.location.href = '/contactUs'; // Redirect to Contact Us page
    });
    // Add event listener to close button
    document.getElementById('closeButton').addEventListener('click', function() {
        document.getElementById('contactModal').style.display = 'none';
    });
});
