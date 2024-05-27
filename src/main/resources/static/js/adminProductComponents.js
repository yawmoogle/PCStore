    function toggleDropdown() {
    var dropdownContent = document.getElementById("dropdownContent");
    dropdownContent.style.display === "block" ? dropdownContent.style.display = "none" : dropdownContent.style.display = "block";
}

    document.addEventListener("click", function(event) {
    var dropdown = document.getElementById("dropdown");
    var dropdownContent = document.getElementById("dropdownContent");
    var target = event.target;

    // Check if the clicked element is inside the dropdown or the button itself
    if (!dropdown.contains(target) && target !== dropdown) {
    dropdownContent.style.display = "none";
}
})

    // function confirmReset() {
    // 	if (confirm("Reset Selection\n\nAre you sure you want to clear all selections?")) {
    // 		// User confirmed, clear CPU components from session
    // 		window.location.href = "/admin/resetSelection"; // Redirect to reset endpoint
    // 	}
    // }


    function validateAllComponentsSelected() {
        if (!isAllComponentsSelected()) {
            alert("Please select all components before saving.");
            return false;
        }
        return true;
    }

    function isAllComponentsSelected() {
    if (!document.querySelector('input[name="cpuName"]').value) {
    return false;
}

    if (!document.querySelector('input[name="cpuCoolerName"]').value) {
    return false;
}

    if (!document.querySelector('input[name="motherboardName"]').value) {
    return false;
}

    if (!document.querySelector('input[name="memoryName"]').value) {
    return false;
}

    if (!document.querySelector('input[name="storageName"]').value) {
    return false;
}

    if (!document.querySelector('input[name="videoCardName"]').value) {
    return false;
}

    if (!document.querySelector('input[name="computerCaseName"]').value) {
    return false;
}

    if (!document.querySelector('input[name="powerSupplyName"]').value) {
    return false;
}

    return true;
}

    function showResetModal() {
    console.log("Showing reset modal"); // Add this line
    document.getElementById("resetModal").style.display = "flex";
}

    function closeResetModal() {
    document.getElementById("resetModal").style.display = "none";
}

    // Event listener for the reset button
    document.querySelector('.reset-button').addEventListener('click', function(event) {
    event.preventDefault();
    showResetModal();
});

    // Function to reset selection
    function resetSelection() {
    // Clear CPU components from session or perform any other reset action
    window.location.href = "/admin/resetSelection"; // Redirect to reset endpoint
}


    // Calculate and display total price
    function calculateTotalPrice() {
    var totalPrice = 0;
    // Loop through each row and sum up the prices
    var rows = document.querySelectorAll('.component-table tbody tr');
    rows.forEach(function(row) {
    var price = parseFloat(row.querySelector('td:nth-child(2)').textContent.replace('$', ''));
    if (!isNaN(price)) {
    totalPrice += price;
}
});
    // Update the total price display
    var totalPriceContainer = document.getElementById('totalPriceContainer');
    var totalPriceDisplay = document.getElementById('totalPrice');
    totalPriceDisplay.textContent = '$' + totalPrice.toFixed(2);
    if (totalPrice === 0) {
    totalPriceContainer.style.display = 'none';
} else {
    totalPriceContainer.style.display = 'block';
}
}

    // Calculate total price initially
    calculateTotalPrice();
