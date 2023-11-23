#!/bin/bash

# Initialize a counter
counter=1

# Loop through all JPEG images in the current directory
for img in *.jpeg; do
  # Format the new image name with the counter value
  newname="image${counter}.jpeg"

  # Rename the image
  mv -- "$img" "$newname"

  # Increment the counter
  ((counter++))
done

echo "Renaming complete."
