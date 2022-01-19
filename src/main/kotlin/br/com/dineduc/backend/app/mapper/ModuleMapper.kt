package br.com.dineduc.backend.app.mapper

import br.com.dineduc.backend.app.dto.*
import br.com.dineduc.backend.service.facade.valueObject.*


class ModuleMapper {
    companion object {

        fun moduleDtoFromModuleVO(moduleVO: ModuleVO): ModuleDto {
            val lessons = moduleVO.lessons?.map { lessonDtoFromLessonVO(it) }
            return  ModuleDto(moduleVO.id, moduleVO.title, moduleVO.description, moduleVO.published_at,
                trailDtoFromTrailVO(moduleVO.trail), bannerDtoFromMediaVO(moduleVO.banner), lessons?.toList(),
                moduleTestListFromModuleTestVO(moduleVO.module_test))
        }

        fun lessonDtoFromLessonVO(lessonVO: LessonVO): LessonDto {
            return LessonDto(lessonVO.id, lessonVO.title, lessonVO.description, lessonVO.content,
                bannerDtoFromMediaVO(lessonVO.banner), videoDtoFromMediaVO(lessonVO.video) )
        }

        fun bannerDtoFromMediaVO(bannerVO: MediaVO?): MediaDto? {
            bannerVO?.let {
                return MediaDto(it.alternativeText, it.caption, it.url, it.previewUrl)
            }
            return null
        }

        fun videoDtoFromMediaVO(videoVO: MediaVO?): MediaDto? {
            videoVO?.let {
                return MediaDto(it.alternativeText, it.caption, it.url, it.previewUrl)
            }
            return null
        }

        fun trailDtoFromTrailVO(trailVO: TrailVO?): TrailDto? {
            trailVO?.let {
                return TrailDto(it.id, it.title, it.description, it.published_at)
            }
            return null
        }

        fun moduleTestListFromModuleTestVO(moduleTestsVO: ModuleTestsVO?) : ModuleTestDto? {
            moduleTestsVO?.let {
                return moduleTestDtoFromModuleTestsVO(it)
            }
            return null
        }

        fun moduleTestDtoFromModuleTestsVO(moduleTestsVO: ModuleTestsVO) : ModuleTestDto {

            return ModuleTestDto(moduleTestsVO.id,moduleTestsVO.title, moduleTestsVO.published_at, questionsDtoFromQuestionsVO(moduleTestsVO.questions))

        }

        fun questionsDtoFromQuestionsVO(questions : List<QuestionVO>? ) : List<QuestionDto> {
            questions?.let{
                return (questions.map {
                    QuestionDto(it.id, it.question, answerDtoFromAnswerVO(it.answer))
                }).toList()
            }
            return listOf<QuestionDto>()
        }

        fun answerDtoFromAnswerVO(answers : List<AnswerVO>? ) : List<AnswerDto> {
            answers?.let{
                return (answers.map {
                    AnswerDto(it.id, it.text)
                }).toList()
            }
            return listOf<AnswerDto>()
        }

    }
}