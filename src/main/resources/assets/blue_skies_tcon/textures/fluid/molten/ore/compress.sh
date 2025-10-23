#!/bin/bash

# shellcheck disable=SC2016
find "." -name "*.png" -type f -print0 | xargs -0 -n1 -P16 bash -c '
  img="$0"
  colors=$(magick "$img" -format %k info:)
  tmpfile=$(mktemp --suffix=.png)
  if magick identify -verbose "$img" | grep -q "Class: DirectClass" && [ "$colors" -lt 256 ]; then
    printf "Indexing and Compressing: %s (%d colors)\n" "$img" "$colors"
    magick "$img" -strip -dither None -colors 256 PNG8:"$tmpfile"
    pngcrush -rem allb -brute "$tmpfile" "$img" > /dev/null 2>&1
  else
    printf "Compressing: %s (%d colors)\n" "$img" "$colors"
    pngcrush -rem allb -brute "$img" "$tmpfile" > /dev/null 2>&1
    mv "$tmpfile" "$img"
  fi
'
