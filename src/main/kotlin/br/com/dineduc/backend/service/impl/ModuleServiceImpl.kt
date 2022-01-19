package br.com.dineduc.backend.service.impl

import br.com.dineduc.backend.handler.exception.NotFoundException
import br.com.dineduc.backend.handler.exception.UnexpectedException
import br.com.dineduc.backend.infraestructure.http.CMSClient
import br.com.dineduc.backend.service.ModulesService
import br.com.dineduc.backend.service.facade.valueObject.ModuleTestsVO
import br.com.dineduc.backend.service.facade.valueObject.ModuleVO
import feign.FeignException
import org.intellij.markdown.flavours.MarkdownFlavourDescriptor
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import org.springframework.stereotype.Service


@Service
class ModuleServiceImpl  (
    private val cmsClient: CMSClient
        ): ModulesService {
    override fun getModule(moduleId: Long): ModuleVO {
        try{
            val moduleVO = cmsClient.getModule(moduleId)
            val flavour = CommonMarkFlavourDescriptor()

            moduleVO.lessons?.onEach {
                val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(it.content)
                var html = HtmlGenerator(it.content, parsedTree, flavour).generateHtml()
                html.replace("\n", "<br>")
                it.content = html
            }

            return moduleVO
        }catch (exception : FeignException){
            if (exception.status() == 404){
                throw NotFoundException("Module was not found, try a different id or try again later",  "Not found error")
            }
            throw UnexpectedException(exception.message ?: exception.status().toString(), "Unexpected Error")
        }
    }

    override fun getModules(): List<ModuleVO> {
        val modulesVO = cmsClient.getModules()
        val flavour = CommonMarkFlavourDescriptor()

        modulesVO.forEach { vo ->
            vo.lessons?.onEach {
                val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(it.content)
                var html = HtmlGenerator(it.content, parsedTree, flavour).generateHtml()
                html.replace("\n", "<br>")
                it.content = html
            }
            }
        return modulesVO

    }

    override fun getModuleTest (moduleId: Long): ModuleTestsVO {
        try{
            val tests: List<ModuleTestsVO> =  cmsClient.getModuleTest(moduleId)
            if(tests.isNotEmpty()){
                return tests.first()
            }else{
                throw NotFoundException("Test for module was not found, try a different id or try again later",  "Not found error")
            }
        }catch (exception : FeignException){
            if (exception.status() == 404){
                throw NotFoundException("Test for module was not found, try a different id or try again later",  "Not found error")
            }
            throw UnexpectedException(exception.message ?: exception.status().toString(), "Unexpected Error")
        }
    }
}