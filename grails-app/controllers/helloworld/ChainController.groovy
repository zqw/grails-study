package helloworld

class ChainController {

    def first() {
        chain(action: "second", model: [one: 1])
    }

    def second () {
        chain(action: "third", model: [two: 2])
    }

    def third() {
        def model = chainModel.myModel
        render(view: "/book/show", model: model)
    }
}
