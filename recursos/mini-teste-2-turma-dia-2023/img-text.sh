#!/bin/bash

# Define the output Markdown file
output_file="extracted_text.md"

# Empty or create the output file
> "$output_file"

# Loop through all JPEG images in the current directory
for img in *.jpeg; do
  # Use Tesseract to extract text from the image and append it to the Markdown file
  tesseract "$img" stdout >> "$output_file"
  
  # Optionally, add a separator between the contents of different images
  echo -e "\n\n---\n\n" >> "$output_file"
done

echo "Text extraction completed and saved to $output_file."
