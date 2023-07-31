package springBoot.exoRecette.controller;

import org.springframework.web.bind.annotation.*;
import springBoot.exoRecette.model.Recette;
import springBoot.exoRecette.service.RecetteService;

import java.util.List;

@RestController
@RequestMapping("/recettes")
public class RecetteController {

    private final RecetteService recettesService;

    public RecetteController(RecetteService recettesService) {
        this.recettesService = recettesService;
    }

    @GetMapping("/all")
    public List<Recette> findAll() {
        return recettesService.findAll();
    }

    @GetMapping("/{id}")
    public Recette findById(@PathVariable String id) {
        return recettesService.findById(id);
    }

    @PostMapping("/add")
    public Recette save(@RequestBody Recette recette) {
        return recettesService.save(recette);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable String id) {
        recettesService.deleteById(id);
    }

    @DeleteMapping("delete/all")
    public void deleteAll() {
        recettesService.deleteAll();
    }

    @PatchMapping("/update/{id}")
    public Recette update(@PathVariable String id, @RequestBody Recette recette) {
        return recettesService.update(id, recette);
    }
}
