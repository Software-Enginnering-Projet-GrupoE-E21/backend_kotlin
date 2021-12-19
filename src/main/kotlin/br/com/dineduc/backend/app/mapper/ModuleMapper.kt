package br.com.dineduc.backend.app.mapper

import br.com.dineduc.backend.app.dto.MediaDto
import br.com.dineduc.backend.app.dto.LessonDto
import br.com.dineduc.backend.app.dto.ModuleDto
import br.com.dineduc.backend.app.dto.TrailDto
import br.com.dineduc.backend.service.facade.valueObject.MediaVO
import br.com.dineduc.backend.service.facade.valueObject.LessonVO
import br.com.dineduc.backend.service.facade.valueObject.ModuleVO
import br.com.dineduc.backend.service.facade.valueObject.TrailVO


class ModuleMapper {
    companion object {

        fun moduleDtoFromModuleVO(moduleVO: ModuleVO): ModuleDto {
            val lessons = moduleVO.lessons?.map { lessonDtoFromLessonVO(it) }
            return  ModuleDto(moduleVO.id, moduleVO.title, moduleVO.description, moduleVO.published_at, trailDtoFromTrailVO(moduleVO.trail), bannerDtoFromMediaVO(moduleVO.banner), lessons?.toList())
        }

        fun lessonDtoFromLessonVO(lessonVO: LessonVO): LessonDto {
            return LessonDto(lessonVO.id, lessonVO.title, lessonVO.description, lessonVO.content, bannerDtoFromMediaVO(lessonVO.banner), videoDtoFromMediaVO(lessonVO.video) )
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
    }
}