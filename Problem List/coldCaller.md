  Given an array of names, write a function `coldCaller` which returns a random student's name from the input array.

  Coldcaller does not call on the same student twice before everyone else has been called at least once. Once it has
  called on everyone, it can call on the same student once again (In other words, `coldCaller` will always call on
  a student, and never "run out" of students to call on).

  Example:

  `coldCaller(["Kyler", "Vignesh", "Scott", "Chris"]) // Scott `

  `coldCaller(["Kyler", "Vignesh", "Scott", "Chris"]) // Kyler `
