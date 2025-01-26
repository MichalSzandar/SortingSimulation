# Sorting Simulation

A JavaFX-based application that allows users to visualize various sorting algorithms. This project enables users to select a sorting algorithm, specify the number of elements to sort, adjust the delay between swaps, and watch the sorting process in real-time.

---

## Features

- **Choose Sorting Algorithm**: Select from a variety of sorting algorithms (e.g., Bubble Sort, Quick Sort, Merge Sort, etc.).
- **Customizable Input**: Specify the number of elements to sort.
- **Adjustable Delay**: Control the speed of the visualization by setting the delay between swapping elements.
- **Dynamic Visualization**: Watch the sorting process unfold in real-time.

---

## Prerequisites

Before running the project, ensure you have the following installed:

- **Java Development Kit (JDK)** (version 21 or higher)
- **JavaFX SDK**

---

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone <repository_url>
   cd sorting-visualizer
   ```

2. **Download JavaFX SDK**:
   - Visit the [JavaFX official website](https://openjfx.io) and download the appropriate SDK for your system.
   - Extract the SDK to a directory on your system.

3. **Set JavaFX Path**:
   - Add the JavaFX SDK to your project's `--module-path`.

4. **Run the Application**:
   - Use your IDE (e.g., IntelliJ IDEA, Eclipse) to set up the project.
   - Configure the VM options for JavaFX (example for IntelliJ):
     ```
     --module-path "<path_to_javafx_sdk>" --add-modules javafx.controls,javafx.fxml
     ```
   - Build and run the project.

---

## Usage

1. Launch the application.
2. Select a sorting algorithm from the dropdown menu.
3. Specify the number of elements to sort.
4. Adjust the delay slider to set the delay between swaps (in milliseconds).
5. Click the **Start** button to begin the visualization.

---

## Supported Sorting Algorithms

- Bubble Sort
- Insertion Sort
- Merge Sort
- Quick Sort

---

## Future Enhancements

- Add support for additional sorting algorithms.
- Allow custom input arrays from users.
- pause the algorithm and resume.
- display number of comparisons and swaps .

---

## Contributing

Contributions are welcome! If you'd like to contribute, please:

1. Fork the repository.
2. Create a new branch for your feature (`git checkout -b feature-name`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Create a Pull Request.

---

## Acknowledgments

- GeeksForGeeks for some algorithm implementations


