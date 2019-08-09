workflow "Build project" {
  on = "push"
  resolves = ["Build container"]
}

action "Build container" {
  uses = "./.github/build-action/"
}
